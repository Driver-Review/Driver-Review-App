package com.driverreview;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.driverreview");

        noClasses()
            .that()
            .resideInAnyPackage("com.driverreview.service..")
            .or()
            .resideInAnyPackage("com.driverreview.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.driverreview.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}

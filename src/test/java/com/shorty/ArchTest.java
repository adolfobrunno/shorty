package com.shorty;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


class ArchTest {

    @Test
    void shouldDomainLayerDependsOnlyDomainLayerClasses() {
        JavaClasses domainClasses = new ClassFileImporter().importPackages("com.shorty.domain");

        ArchRule entityDependsRule = classes().that()
                .resideInAPackage("..entity..")
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage("..entity..", "java..");

        ArchRule servicesCanDependsEntityClassesRule = classes().that()
                .resideInAnyPackage("..service..")
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage("java..", "..domain..");

        entityDependsRule.check(domainClasses);
        servicesCanDependsEntityClassesRule.check(domainClasses);

    }


}

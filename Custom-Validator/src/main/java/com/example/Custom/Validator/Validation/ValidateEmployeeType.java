package com.example.Custom.Validator.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Firstly we will create a annotation class and here below is how we create an annotation class 

// We Also need to add few annotation to tell our class what kinda annotation class are we creating

@Target({ ElementType.FIELD, ElementType.PARAMETER }) // Here we mention at what level do we want it to implement for
                                                      // field,parameter,method lable,constructor level,etc

// Next is you mention retention
/*
 * Indicates how long annotations with the annotated interface are to be
 * retained. If no Retention annotation is present on an annotation
 * interface declaration, the retention policy defaults to
 * RetentionPolicy.CLASS.
 */

/*
 * Annotation retention policy. The constants of this enumerated class describe
 * the various policies for retaining annotations. They are used
 * in conjunction with the Retention meta-annotation interface to specify how
 * long annotations are to be retained.
 */
@Retention(RetentionPolicy.RUNTIME)

/*
 * If the annotation @Documented is present on the declaration of an annotation
 * interface A, then any @A annotation on an element is considered part
 * of the element's public contract. In more detail, when an annotation
 * interface A is annotated with Documented, the presence and value of A
 * annotations are a part of the public contract of the elements A annotates.
 * Conversely, if an annotation interface B is not annotated with
 * Documented, the presence and value of B annotations are not part of the
 * public contract of the elements B annotates. Concretely, if an
 * annotation interface is annotated with Documented, by default a tool like
 * javadoc will display annotations of that interface in its
 * output while annotations of annotation interfaces without Documented will not
 * be displayed.
 */
@Documented

/*
 * A given constraint annotation must be annotated by a @Constraint annotation
 * which refers to its list of constraint validation implementations.
 * 
 * Each constraint annotation must host the following attributes:
 * 
 * String message() default [...]; which should default to an error message key
 * made of the fully-qualified class name of the constraint followed by
 * .message. For example `` "{com.acme.constraints.NotSafe.message}"}
 * `` Class[] groups() default {};} for user to customize the targeted groups
 * `` Class[] payload() default {};} for extensibility purposes
 * 
 * 
 * Then building a constraint that is both generic and cross-parameter, the
 * constraint annotation must host the validationAppliesTo() property. A
 * constraint is generic if it targets the annotated element and is
 * cross-parameter if it targets the array of parameters of a method or
 * constructor.
 */
@Constraint(validatedBy = EmployeeTypeValidator.class) // Basically it tells where the actual business validation logic
                                                       // and code is written for this particular validation or
                                                       // annotation
public @interface ValidateEmployeeType {

    // Here we can also give a default message
    public String message() default "Invalid employeeType: It should be either Permanent Or vendor";

    // Below these 2 methods are always written without any changes so these could
    // be copied by implementatin of any other annotation and pasted here.
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

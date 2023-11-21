package umc.study.validation.annotation;

import umc.study.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented         // 사용자 정의 어노테이션 만들 때
@Constraint(validatedBy = CategoriesExistValidator.class)           // CategoriesExistValidator 클래스를 통해 @ExistCategories가 붙은 대상을 검증
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })      // 어노테이션의 적용 범위를 지정
@Retention(RetentionPolicy.RUNTIME)             // 어노테이션의 생명주기를 지정 (runtime이기 때문에 실행하는 동안만 유효)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
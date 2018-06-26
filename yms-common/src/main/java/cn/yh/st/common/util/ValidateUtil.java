package cn.yh.st.common.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.yh.st.common.exception.ValiAutoHandedException;
import cn.yh.st.common.exception.ValidatorSingleFactory;
import cn.yh.st.common.util.jackson.JsonMapper;

public class ValidateUtil {
	private static Logger logger = LoggerFactory.getLogger(ValidateUtil.class);

	private static JsonMapper mapper = JsonMapper.nonEmptyMapper();

	public static <T> void validate(T requestObject) {

		logger.info("请求参数：" + mapper.toJson(requestObject));

		// 先验证是否为空
		if (!StringUtil.objectIsNotNull(requestObject)) {
			throw new ValiAutoHandedException(ErrorMsg.VALIDATE_ERROR, new ValidateMsgVO(
					"requestObject", "不能为空", null));
		}

		Validator validator = ValidatorSingleFactory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(requestObject);
		if (!violations.isEmpty()) {
			throw new ValiAutoHandedException(ErrorMsg.VALIDATE_ERROR, violations);
		}
	}
}

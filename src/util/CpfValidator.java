package util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "cpfValidator")
public class CpfValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String cpf = value.toString().replaceAll("[^0-9]", "");
		if (cpf.length() != 11) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF inválido", null));
		}
	}

}

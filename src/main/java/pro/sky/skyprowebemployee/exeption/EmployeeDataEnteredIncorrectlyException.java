package pro.sky.skyprowebemployee.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Данные внесены неверно.")
public class EmployeeDataEnteredIncorrectlyException extends RuntimeException{
}

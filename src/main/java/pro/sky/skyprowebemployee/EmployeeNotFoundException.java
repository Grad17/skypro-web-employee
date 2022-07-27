package pro.sky.skyprowebemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Сотрудник не найден")
public class EmployeeNotFoundException extends RuntimeException {
}

package pro.sky.skyprowebemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Массив переполнен.")
public class EmployeeStorageIsFullException extends RuntimeException {
}

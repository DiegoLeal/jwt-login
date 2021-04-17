package jwtlogin.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registro")
@AllArgsConstructor
public class RegistroController {

    private RegistroService registroService;

    public String registro(@RequestBody RegistroRequest request) {
        return registroService.registro(request);
    }
}

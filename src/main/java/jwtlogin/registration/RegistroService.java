package jwtlogin.registration;

import jwtlogin.model.Usuario;
import jwtlogin.model.UsuarioRole;
import jwtlogin.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistroService {

    private final UsuarioService usuarioService;

    private final EmailValidator emailValidator;

    public String registro(RegistroRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email não é valido");
        }

        return usuarioService.signUpUser(
                new Usuario(
                        request.getNome(),
                        request.getEmail(),
                        request.getSenha(),
                        UsuarioRole.USER
                )
        );
    }
}

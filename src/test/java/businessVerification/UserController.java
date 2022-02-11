package businessVerification;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther ChenShuHong
 * @Date 2022-02-09 14:39
 */
@RestController
@RequestMapping("/senior/user")
@Slf4j
@Validated
public class UserController {



  @PostMapping
  public User createUser(@UniqueUser @Valid User user){


    return new User();
  }

  @SneakyThrows
  @PutMapping
  public User updateUser(@NotConflictUser @Valid @RequestBody User user){

    return new User();
  }
}

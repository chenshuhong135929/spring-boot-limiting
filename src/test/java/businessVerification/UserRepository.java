package businessVerification;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther ChenShuHong
 * @Date 2022-02-09 14:31
 */
@Service
public class UserRepository {

  boolean existsByUserNameOrEmailOrTelphone(String name,String email,String phone){
    return true;
  }

 List findByUserNameOrEmailOrTelphone(String name, String email, String phone){
    return Arrays.asList(new User());
  }
}

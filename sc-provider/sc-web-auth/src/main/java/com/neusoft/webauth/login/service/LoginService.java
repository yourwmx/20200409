package  com.neusoft.webauth.login.service;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.webauth.login.dao.LoginDao;
import com.neusoft.webauth.login.entity.UserDataInfo;
import com.neusoft.webauth.utils.AppResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * 用户实现类
 * wumaoxing
 * 2020-03-26 9:07
 */
@Service
public class LoginService {
    @Resource
    private LoginDao loginDao;

    /**
     * 个人信息查询
     * wumaoxing
     * 2020-03-26 9:08
     * @return
     */
    public AppResponse findInformationById() {
        String userId = SecurityUtils.getCurrentUserId();
        UserDataInfo userPersonalMsgInfo = loginDao.findInformationById(userId);
        return AppResponse.success("查询成功！", userPersonalMsgInfo);
    }
}

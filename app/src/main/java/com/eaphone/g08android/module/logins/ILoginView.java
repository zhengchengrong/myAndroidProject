package com.eaphone.g08android.module.logins;

import com.eaphone.g08android.api.bean.BaseEntity;
import com.eaphone.g08android.api.bean.LoginInfoBean;
import com.eaphone.g08android.module.base.IBaseView;

/**ILoginView
 * Created by zhengchengrong on 2017/9/4.
 */

public interface ILoginView extends IBaseView{


    void toActivity(String loginInfoBean);

    void saveLoginInfo(BaseEntity<LoginInfoBean> loginInfoBean);
}

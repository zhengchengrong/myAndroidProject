package com.zcr.myproject.module.logins;

import com.zcr.myproject.api.bean.BaseEntity;
import com.zcr.myproject.api.bean.LoginInfoBean;
import com.zcr.myproject.module.base.IBaseView;

/**ILoginView
 * Created by zhengchengrong on 2017/9/4.
 */

public interface ILoginView extends IBaseView{


    void toActivity(String loginInfoBean);

    void saveLoginInfo(BaseEntity<LoginInfoBean> loginInfoBean);
}

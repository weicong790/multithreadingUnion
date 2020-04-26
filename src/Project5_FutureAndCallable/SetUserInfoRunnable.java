package Project5_FutureAndCallable;

import Project3_Phaser.onAdvance3_5.Service;

import javax.jws.soap.SOAPBinding;

public class SetUserInfoRunnable implements Runnable {
    UserInfo userInfo ;

    public SetUserInfoRunnable(UserInfo userInfo){
        super();
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
            userInfo.setUsername("chenhanyi");
            userInfo.setPassword("1213456");
    }
}

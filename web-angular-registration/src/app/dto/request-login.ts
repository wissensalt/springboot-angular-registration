export class RequestLogin {
    userName : string;
    password : string;

    public setUserName(p_UserName : string) {
        this.userName = p_UserName;
    }

    public getUserName() : string {
        return this.userName;
    }

    public setPassword(p_Password : string) {
        this.password = p_Password;
    }

    public getPassword() : string {
        return this.password;
    }
}

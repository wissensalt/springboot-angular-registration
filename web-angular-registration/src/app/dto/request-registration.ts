export class RequestRegistration {
    private mobileNumber : string;
    private firstName : string;
    private lastName : string;
    private dob : string;
    private gender : number;
    private email : string;

    public setMobileNumber(p_MobileNumber: string){
        this.mobileNumber = p_MobileNumber;
    }

    public getMobileNumber() : string {
        return this.mobileNumber;
    }

    public setFirstName(p_FirstName: string) {
        this.firstName = p_FirstName;
    }

    public getFirstName() : string {
        return this.firstName;
    }

    public setLastName(p_LastName : string) {
        this.lastName = p_LastName;
    }

    public getLastName() : string {
        return this.lastName;
    }

    public setDob(p_Dob : string) {
        this.dob = p_Dob;
    }

    public getDob() : string {
        return this.dob;
    }

    public setGender(p_Gender : number) {
        this.gender = p_Gender;
    }

    public getGender() : number {
        return this.gender;
    }

    public setEmail(p_Email : string) {
        this.email = p_Email;
    }

    public getEmail() : string {
        return this.email;
    }
}

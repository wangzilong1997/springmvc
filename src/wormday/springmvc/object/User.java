package wormday.springmvc.object;

public class User {
    private String name;
    private Integer age;

    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User:"+ name +",age:"+age+",contactInfo=" + contactInfo;
    }
}

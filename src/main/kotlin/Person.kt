class Person(var firstname: String, var surname: String, var phonenumber: String, var email: String)
{
    init {
        this.firstname = firstname
        this.surname = surname
        this.phonenumber = phonenumber
        this.email = email

        println("Kontakt skapad")
    }
}
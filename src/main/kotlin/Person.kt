class Person(var firstname: String, var surname: String, var phonenumber: String, var email: String)
{
    init {
        firstname = readln()
        surname = readln()
        phonenumber = readln()
        email = readln()

        println("Kontakt skapad")
    }


}
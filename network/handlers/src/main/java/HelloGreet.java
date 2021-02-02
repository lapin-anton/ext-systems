public class HelloGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Hello, " + userName;
    }
}

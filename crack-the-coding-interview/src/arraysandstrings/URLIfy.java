package arraysandstrings;

/**
 * I have just solved the problem in regular java here, I'm sure this wouldn't suffice in an interview, but I don't
 * understand the question - I don't get the idea of true length and how that has an impact on replacing the spaces in
 * the string?
 */
public class URLIfy {


    static String urlify(String input){
        String result = input.trim().replaceAll("(\\s)+", "%20");
        return result;
    }

    public static void main(String[] args){
        urlify("Mr John Smith   ");
    }
}

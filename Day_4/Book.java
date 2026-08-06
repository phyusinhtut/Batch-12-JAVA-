public class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    double makeDiscount(int percent)
    {
        double discountedprice = price * ((double) (100 - percent) / 100);
        return discountedprice;
    }
    public void displayBook()
    {
        System.out.println("Title - " + title);
        System.out.println("Author - " + author);
        System.out.println("Price - " + price);
    }
    public static void main(String[] args) {
       Book book1 = new Book("1984","George Orwell",1000);
       Book book2 = new Book("The Great Gatsby","F. Scott Fitzgerald",25000);
       Book book3 = new Book("To Kill a Mockingbird","Harper Lee",13000);

       book1.displayBook();
        System.out.println("Discounted Price - "+book1.makeDiscount(5));
    }
}

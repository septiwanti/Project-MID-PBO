import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class MenuItem {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Review {
    private String reviewText;
    private int rating;

    public Review(String reviewText, int rating) {
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}

class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private List<Review> reviews;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }
}

class Payment {
    public static String processPayment(Object order) {
        // Simulasi proses pembayaran
        return "Payment processed for order.";
    }
}

class Tracking {
    public static String trackOrder(Object order) {
        // Simulasi pelacakan pesanan
        return "Order is being tracked.";
    }
}

class Notification {
    public static String sendNotification(Object order) {
        // Simulasi notifikasi
        return "Notification sent for order.";
    }
}

class Cart {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }
}

public class Phase2 {
    // Deklarasi variabel global
    private static List<Restaurant> restaurants = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static Cart cart = new Cart();
    private static Map<Integer, Object> orders = new HashMap<>(); // Simulasi daftar pesanan
    private static int currentOrderId = 1; // Simulasi ID pesanan

    // 1. Pendaftaran Pengguna
    public static String registerUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
        return "User registered successfully: " + newUser.getUsername();
    }

    // 2. Login Pengguna
    public static String loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "User logged in successfully: " + username;
            }
        }
        return "Invalid username or password!";
    }

    // 3. Pencarian Restoran
    public static String searchRestaurant(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                return "Restaurant found: " + restaurant.getName();
            }
        }
        return "Restaurant found!";
    }

    // 4. Keranjang Belanja
    public static String addToCart(String itemName) {
        for (Restaurant restaurant : restaurants) {
            for (MenuItem item : restaurant.getMenu()) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    cart.addItem(item);
                    return item.getName() + " added to cart.";
                }
            }
        }
        return "Menu item found!";
    }

    // 5. Pembayaran
    public static String payment(int orderId) {
        if (orders.containsKey(orderId)) {
            return Payment.processPayment(orders.get(orderId));
        }
        return "Order found!";
    }

    // 6. Pelacakan Pesanan Realtime
    public static String trackOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            return Tracking.trackOrder(orders.get(orderId));
        }
        return "Order found!";
    }

    // 7. Ulasan dan Rating
    public static String addReview(String restaurantName, String reviewText, int rating) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                restaurant.getReviews().add(new Review(reviewText, rating));
                return "Review added successfully!";
            }
        }
        return "Restaurant found!";
    }

    public static List<Review> getReviews(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                return restaurant.getReviews();
            }
        }
        return null; // Restaurant found
    }

    // 8. Notifikasi (Simulasi)
    public static String notifyUser(int orderId) {
        if (orders.containsKey(orderId)) {
            return Notification.sendNotification(orders.get(orderId));
        }
        return "Order found!";
    }

    // 9. Promosi dan Diskon
    public static String applyPromotion(String code) {
        // Simulasi penerapan promosi
        return "Promotion applied: " + code;
    }

    // 10. Riwayat Pesanan
    public static String getOrderHistory() {
        // Simulasi pengambilan riwayat pesanan
        return "Order history retrieved successfully.";
    }

    // 11. Layanan Bantuan
    public static String getSupport() {
        return "Contact us at support@example.com for assistance.";
    }

    // 12. Profil Pengguna dan Pengaturan
    public static String updateUserProfile(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                user.setPassword(password);
                return "User profile updated: " + username;
            }
        }
        return "User found!";
    }

    // 13. Menampilkan Menu Utama
    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("==== Main Menu ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Search Restaurant");
            System.out.println("4. Add to Cart");
            System.out.println("5. Make Payment");
            System.out.println("6. Track Order");
            System.out.println("7. Add Review");
            System.out.println("8. Apply Promotion");
            System.out.println("9. Order History");
            System.out.println("10. Get Support");
            System.out.println("11. Update Profile");
            System.out.println("12. Exit");
            String choice = input("Choose an option: ");
            switch (choice) {
                case "1":
                    String username = input("Enter username");
                    String password = input("Enter password");
                    System.out.println(registerUser(username, password));
                    break;

                case "2":
                    username = input("Enter username");
                    password = input("Enter password");
                    System.out.println(loginUser(username, password));
                    break;

                case "3":
                    String restaurantName = input("Enter restaurant name");
                    System.out.println(searchRestaurant(restaurantName));
                    break;

                case "4":
                    String itemName = input("Enter menu item to add");
                    System.out.println(addToCart(itemName));
                    break;

                case "5":
                    int orderId = Integer.parseInt(input("Enter order ID"));
                    System.out.println(payment(orderId));
                    break;

                case "6":
                    orderId = Integer.parseInt(input("Enter order ID"));
                    System.out.println(trackOrder(orderId));
                    break;

                case "7":
                    restaurantName = input("Enter restaurant name");
                    String reviewText = input("Enter your review");
                    int rating = Integer.parseInt(input("Enter rating (1-5)"));
                    System.out.println(addReview(restaurantName, reviewText, rating));
                    break;

                case "8":
                    String promoCode = input("Enter promotion code");
                    System.out.println(applyPromotion(promoCode));
                    break;

                case "9":
                    System.out.println(getOrderHistory());
                    break;

                case "10":
                    System.out.println(getSupport());
                    break;

                case "11":
                    username = input("Enter your username");
                    password = input("Enter new password");
                    System.out.println(updateUserProfile(username, password));
                    break;

                case "12":
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method untuk menerima input dari pengguna
    public static String input(String info) {
        System.out.print(info + ": ");
        return new java.util.Scanner(System.in).nextLine();
    }

    // Menambahkan method main untuk menjalankan program
    public static void main(String[] args) {
        // Inisialisasi aplikasi dan contoh pengguna dan restoran
        Restaurant restaurant1 = new Restaurant("Pizza Palace");
        restaurant1.addMenuItem(new MenuItem("Pepperoni Pizza"));
        restaurants.add(restaurant1);

        // Menampilkan menu utama
        showMainMenu();
    }
}
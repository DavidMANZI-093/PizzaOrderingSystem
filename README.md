# Pizza Ordering System
---

## 📦 Project Structure

```
src/
└── main/
    ├── app/         → Contains the main class `PizzaTester`
    ├── model/       → Core classes: `Pizza`, `Order`, `Customer`, `InvalidPizzaException`
    └── enums/       → Enum definitions for all types (Meat, Veggie, etc.)
```

---

## 🚀 How to Run the Program

1. **Open terminal in `src/main/`**
2. **Compile the classes**
    ```powershell
    javac app/*.java model/*.java enums/*.java
    ```

3. **Run the main app**
    ```powershell
    java app/PizzaTester.java
    ```

---

## 🧑‍🍳 How it Works

- You’ll be asked how many pizzas you want to order.
- For each pizza, enter:
  - Number of slices
  - Meat, Veggie, Crust, Size
  - One or more toppings (comma-separated)
- Enter customer name, address, and phone number.
- Choose delivery or pickup.
- Your order is saved to `pizza_orders.json` and displayed on screen.
- The system auto-loads and shows previous orders every time it starts.

---

## 📄 File Format

Orders are saved in a human-readable format to `pizza_orders.json`  
Each order includes:
- Order ID and timestamp
- Customer details
- List of pizzas with price breakdown
- Delivery/pickup option
- Grand total with discount if applicable

---

## 💡 Notes

- Input is case-insensitive, but enum values must match predefined options.
- A 5% discount is applied if you order more than one pizza.
- Invalid entries throw friendly custom exceptions.
- Orders are appended, not overwritten — you’ll always have your order history!

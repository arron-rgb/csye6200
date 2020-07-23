using System;
using System.Collections.Generic;
namespace MidtermProject
{
    public abstract class AbstractStoreModel
    {
        public abstract void AddItem(AbstractItem item);
        public abstract void AddEmployee(Employee employee);

        public abstract void SortInventory();
        public abstract void SortEmployees();

        public abstract void ShowInventory();
        public abstract void ShowEmployees();

        //public abstract void SortInventory(IComparer<AbstractItem> comparer);
        //public abstract void SortEmployees(IComparer<Employee> comparer);
    }
}

/**
 * Given:
 * 1. class AbstractStoreModel
 *
 * Implement the following:
 *
 * NOTE: 10 POINTS for correct, executable, on-time submission of a zipped Eclipse workspace
 * in the correct format,
 * FOR EXAMPLE: MidTerm_dan_peters_applestore.zip:
 *
 * 1. 20 POINTS: class Person derived from your AbstractPerson class.
 * 2. 10 POINTS: class Employee derived from Person.
 *
 * 3. 20 POINTS: class Item derived from your AbstractItem class.
 * 4. 5 POINTS: class IPhone derived from class Item.
 * 5. 5 POINTS: class MacBook derived from class Item.
 * 6. 5 POINTS: class IPad derived from class Item.
 *
 * 7. 15 POINTS: class Store derived from this AbstractStore class
 *  a. Use the following implementation for the ShowInventory() method in the Store class:
        public override void ShowInventory() {
            Console.WriteLine($"{inventory.Count} items in {Name} inventory:");
            foreach (AbstractItem item in inventory) {
                Console.WriteLine(item);
            }
        }
 *
 * 8. 10 POINTS: class AppleStore derived from class Store.
 *  a. create a Demo() method:
 *  - Add employees in no particular order;
 *  - SORT employees by LAST NAME;
 *  - Add items to AppleStore in no particular order
 *  - SORT items by PRICE.
 *
 * USE THE FOLLOWING AppleStore DEMO implementation:
        public static void Demo()
        {
            Console.WriteLine("\n\t AppleStore.Demo()...");
            AppleStore obj = new AppleStore();

            obj.AddEmployee(new Employee());
            obj.AddEmployee(new Employee(2, 17, "Dan", "Peters", 63.45));
            obj.AddEmployee(new Employee(3, 67, "Ann", "Mason", 93.45));
            obj.AddEmployee(new Employee(4, 47, "Sam", "Jones", 53.45));
   
            //obj.AddEmployee(new Employee());
            //obj.AddEmployee(new Employee(2, 17, "Dan", "Peters", 63.45));
            //obj.AddEmployee(new Employee(3, 67, "Ann", "Mason", 93.45));
            //obj.AddEmployee(new Employee(4, 47, "Sam", "Jones", 53.45));
               
            obj.ShowEmployees();
            obj.SortEmployees();
            obj.ShowEmployees();

            obj.AddItem(new IPhone(1, 999.99, "IPhone X MAX", "Verizon"));
            obj.AddItem(new IPhone(2, 899.99, "IPhone X", "Sprint"));
            obj.AddItem(new IPhone(3, 849.99, "IPhone X MAX", "TMobile"));

            obj.AddItem(new IPad(4, 1049.99, "IPad Pro 256 GB", "WiFi"));
            obj.AddItem(new IPad(5,  349.99, "IPad mini 32 GB", "WiFi"));
            obj.AddItem(new IPad(6,  749.99, "IPad 128 GB", "4G"));

            obj.AddItem(new MacBook(7, 1799.99, "17 inch MacBook Pro", "Back-lite Keyboard"));
            obj.AddItem(new MacBook(8, 1299.99, "13 inch MacAir", "Back-lite Keyboard"));
            obj.ShowInventory();

            Console.WriteLine($"Sort Inventory [] BY PRICE");
            obj.SortInventory();
            obj.ShowInventory();

            Console.WriteLine("\n\t AppleStore.Demo()... done!");
        }

 *
 *
 *  CONSOLE OUTPUT:
     AppleStore.Demo()...
4 employees in AppleStore:
# 1 Joe Worker, age 18, Earning a wage of 0
# 2 Dan Peters, age 17, Earning a wage of 0
# 3 Ann Mason, age 67, Earning a wage of 0
# 4 Sam Jones, age 47, Earning a wage of 0
4 employees in AppleStore:
# 4 Sam Jones, age 47, Earning a wage of 0
# 3 Ann Mason, age 67, Earning a wage of 0
# 2 Dan Peters, age 17, Earning a wage of 0
# 1 Joe Worker, age 18, Earning a wage of 0
8 items in AppleStore inventory:
#1 $999.99 IPhone X MAX, connected to the Verizon mobile network.
#2 $899.99 IPhone X, connected to the Sprint mobile network.
#3 $849.99 IPhone X MAX, connected to the TMobile mobile network.
#4 $1049.99 IPad Pro 256 GB WiFi.
#5 $349.99 IPad mini 32 GB WiFi.
#6 $749.99 IPad 128 GB 4G.
#7 $1799.99 17 inch MacBook Pro wih a Back-lite Keyboard.
#8 $1299.99 13 inch MacAir wih a Back-lite Keyboard.
Sort Inventory [] BY PRICE
8 items in AppleStore inventory:
#5 $349.99 IPad mini 32 GB WiFi.
#6 $749.99 IPad 128 GB 4G.
#3 $849.99 IPhone X MAX, connected to the TMobile mobile network.
#2 $899.99 IPhone X, connected to the Sprint mobile network.
#1 $999.99 IPhone X MAX, connected to the Verizon mobile network.
#4 $1049.99 IPad Pro 256 GB WiFi.
#8 $1299.99 13 inch MacAir wih a Back-lite Keyboard.
#7 $1799.99 17 inch MacBook Pro wih a Back-lite Keyboard.

     AppleStore.Demo()... done!

 *
 */

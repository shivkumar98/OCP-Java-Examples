## 5. Composing Objects

**What is object-composition?**

This is the property of creating a class which references another class in order to use its functionality

Instead of relying on inheritance, composition allows for more complex relationships between classes

### Eample

    public class Penguin {
        Flippers flipper;
        WebbedFeet webbedFeet;
        public Penguin() {
            this.flipper = new Flippers();
            this.webbedFeet = new WebbedFeet();
        }
        public void flap() { this.flipper.flap(); }
        public void kick() { this.webbedFeet.kick(); }
    }

    class Flippers {
        public void flap() { System.out.println("The flippers go back and forth"); }
    }
    class WebbedFeet {
        public void kick() { System.out.println("the webbed feet kick to and from"); }
    }
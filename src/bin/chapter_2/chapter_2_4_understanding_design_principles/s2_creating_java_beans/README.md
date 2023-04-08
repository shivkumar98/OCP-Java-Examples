## 2. Creating JavaBeans

**What is a JavaBean?**
JavaBean is another word for encapsulated Jaca class. A JavaBean is a design principle for encapsulating data in a object in java JavaBeans must obide certain properties
    
**Rules for JavaBeans:**

1) properties are private
2) getters for non boolean properties are prefixed with "get"
3) getters for boolean properties may begin with "get" or "is"
4) setters begin with "set"
5) the first letter past the prefix of setter/getter is uppercase character of property

### Example 1:

Suppose a class has the following properties:
    private boolean playing;
    private boolean dancing;
 
 Which of the following would be correctly defined in a JavaBean?
    
    public boolean isPlaying() { return playing; } // valid
    
    public boolean getPlaying() { return playing; } // valid
    
    public Boolean isDancing() { return dancing; } // invalid - this is returning a wrapper class object so should be prefixed with "get"

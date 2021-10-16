# restirced-input
A custom annotation based spring boot starter that helps restricting the input of a field in input.

The maven dependency is used for restricting the user input. 


Dependency Information

```
        <dependency>
            <groupId>com.pmanaktala</groupId>
            <artifactId>restricted-input</artifactId>
            <version>1.0.0</version>
        </dependency>
```

The annotation works as follows : 

```
    @RestrictedInput(valuesToRestrict = {"abc"}, regexToMatch = {"^[a-zA-Z]*$"}, exactMatchValues = true)
    private String name;
```

Description : 

valuesToRestrict 
Contains a list of values that are not allowed

regexToMatch 
Contains a list of regular expression that should match. 
Note : All the regex should match else the validation should fail.

exactMatchValues
If the values in parameter 1, should exactly match or not.

Sample UseCase 

**Use Case 1**

```
    @RestrictedInput(valuesToRestrict = {"abc"}, exactMatchValues = true)
    private String name;
```

Validation will pass on inputs.

1. xyz
2. xyzabc
3. ABC(since input validation is case sensitive)
4. abcx

Validation will fail on

1. abc

**Use Case 2**

```
    @RestrictedInput(valuesToRestrict = {"abc"}, exactMatchValues = false)
    private String name;
```

Validation will pass on inputs.

1. xyz
2. ABC(since input validation is case sensitive)
3. xabyc

Validation will fail on

1. abc
2. xyzabc
3. abcx

<h1 align="center">Welcome to restriced-input 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-3.0.0-blue.svg?cacheSeconds=2592000" />
  <a href="http://www.apache.org/licenses/" target="_blank">
    <img alt="License: Apache License 2.0" src="https://img.shields.io/badge/License-Apache License 2.0-yellow.svg" />
  </a>
</p>

> A helper dependency that has various constraint annotations for restricted inputs.

## Adding Maven Dependency

```xml
        <dependency>
            <groupId>com.pmanaktala</groupId>
            <artifactId>restricted-input</artifactId>
            <version>2.0.0</version>
        </dependency>
```

## Current Features

### 1. Restricted Input
```java
import com.pmanaktala.restrictedinput.annotation.RestrictedInput;

class DTO {
    @RestrictedInput(valuesToRestrict = {"abc"}, regexToMatch = {"^[a-zA-Z]*$"}, exactMatchValues = true)
    private String name;
}
```

#### Description :

Checks if the input satisfies the given conditions.
* All the conditions specified should match.
* If the value is null, the validation will pass.
* By default, `valuesToRestrict` field and `regexToMatch` field is empty. i.e. Validation will always pass

#### Parameters : 

| Field            | Mandatory | Description                                                | Default Value | Comments                                                           |
|------------------|-----------|------------------------------------------------------------|---------------|--------------------------------------------------------------------|
| valuesToRestrict | No        | Contains a list of values that are not allowed             | No value      | NA                                                                 |
| regexToMatch     | No        | Contains a list of regular expression that should match.   | No value      | Note : All the regex should match else the validation should fail. |
| exactMatchValues | No        | If the values in parameter 1, should exactly match or not. | false         | NA                                                                 |

<hr>

### 2. AlphaNumeric Input
```java
import com.pmanaktala.restrictedinput.annotation.AlphaNumericInput;

class DTO {
    @AlphaNumericInput
    private String otherDetails;
}
```
#### Description :
Checks if the input is a valid alphanumeric input of not.

* If the value is null, the validation will fail.

### 3. ValidPhone Input
```java
import com.pmanaktala.restrictedinput.annotation.ValidPhone;

class DTO {
    @ValidPhone(region = "IN")
    private String phoneNumber;
}
```
#### Description :
Checks if the input is a valid phone number input of not.

* The datatype of the input is set to be string, as it can contain symbols such as '+' and '()'

## Author

👤 **Parth Manaktala**

* Website: https://pmanaktala.com
* Github: [@pmanaktala](https://github.com/pmanaktala)

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License
This project is [Apache License 2.0](http://www.apache.org/licenses/) licensed.

***
_This README was generated with the help of  [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_

@LoginPage
Feature: Login Page

  @Check
  Scenario: Check Login Page
    Given User is on Home page
    When  User clicks Giris Yap button at the top right
    Then  User should see Login Page

  @Email @Components
  Scenario: Check Email Components
    Given User is on Login Page
    When  User clicks "E-Posta" radio button
    Then  User should see "GIRIS YAP title"
    Then  User should see "E-Posta radio button"
    Then  User should see "Telefon radio button"
    Then  User should see "E-Posta Adresiniz text on Email"
    Then  User should see "Sifreniz text on Password"
    Then  User should see "Show Password Icon"
    Then  User should see "Beni hatırla text"
    Then  User should see "Sifremi Unuttum link"
    Then  User should see "GIRIS YAP login button"



  @Phone @Components
  Scenario: Check Phone Components
    Given User is on Login Page
    When  User clicks "Telefon" radio button
    Then  User should see "GIRIS YAP title"
    Then  User should see "E-Posta  radio button"
    Then  User should see "Telefon radio button"
    Then  User should see "Phone Text Box"
    Then  User should see "Sifreniz text on Password"
    Then  User should see "Show Password Icon"
    Then  User should see "Beni Hatirla text"
    Then  User should see "Sifremi Unuttum link"
    Then  User should see "GIRIS YAP login button"

  @Empty
  Scenario Outline: Empty Login
    Given User is on Login Page
    When User clicks login button
    Then should see "<emailErr>" Email Error message
    Then should see "<passErr>" Password Empty message
    Examples:
      | emailErr                           | passErr                   |
      | Lütfen e-posta adresinizi giriniz. | Lütfen şifrenizi giriniz. |

  @Empty @Password
  Scenario Outline: Empty Password
    Given User is on Login Page
    When User types Email "<email>"
    When User clicks login button
    Then should see "<passErr>" Password Empty message
    Then should not see Email Empty message
    Examples:
      | email         | passErr                   |
      | username@mail.com | Lütfen şifrenizi giriniz. |

  @Empty @Email
  Scenario Outline: Empty Email
    Given User is on Login Page
    When User types Password "<password>"
    When User clicks login button
    Then should see "<emailErr>" Email Error message
    Then should not see Password Empty message
    Examples:
      | password       | emailErr                           |
      | 1234567890 | Lütfen e-posta adresinizi giriniz. |

  @False @Password
  Scenario Outline: False Email
    Given User is on Login Page
    When User types Email "<email>"
    When User clicks login button
    Then should see "<emailErr>" Email Error message
    Examples:
      | email              | emailErr                                    |
      | user@mail@mail.com | Lütfen geçerli bir e-posta adresi giriniz. |

  @FalseLogin
  Scenario Outline: False Login
    Given User is on Login Page
    When User types Email "<email>"
    When User types Password "<password>"
    When User clicks login button
    Then should see "<err>" Login Error message
    Examples:
      | email         | password | err                                                       |
      | user@mail.com | 123      | Lütfen e-posta ya da şifrenizi kontrol ediniz. |
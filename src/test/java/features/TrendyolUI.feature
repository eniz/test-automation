Feature: Trendyol Test Feature

  Background:
      Given Login Trendyol with username and password

  #2
  #Scenario: Check butiqe image in all tabs
  #    Given At boutique page

  #4
  Scenario: Go to product detail and add basket
       Given At boutique page
       When Go to boutique detail page
       Then At boutique detail page
       When Choose first product
       Then At product detail page
       When Add product in basket


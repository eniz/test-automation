Feature: Trendyol Test Feature

  Background:
      And Login Trendyol with username and password

  #2
#  Scenario: Check boutique images in all tabs
#      Given At boutique page
#      Then Click boutique category tab and image check

   #3
  Scenario: Check product image
    Given At boutique page
       When Go to boutique detail page
       Then At boutique detail page
       When Choose first product
       Then At product detail page
       Then Check product images

  #4
#  Scenario: Go to product detail and add basket
##       Given At boutique page
##       When Go to boutique detail page
##       Then At boutique detail page
##       When Choose first product
##       Then At product detail page
##       When Add product in basket


package com.swedbank.itacademy.leasing.demoApp.utils;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.constants.CustomerConstants;
import com.swedbank.itacademy.leasing.demoApp.models.customer.CustomerType;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Customer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class CustomerUtils implements CustomerConstants {
    public static List<CustomerResponse<Private>> privatesToResponse(List<Private> privates) {
        List<CustomerResponse<Private>> responses = new ArrayList<CustomerResponse<Private>>();
        for (Private p : privates) {
            CustomerResponse<Private> r = new CustomerResponse<Private>(p);
            responses.add(r);
        }
        return responses;
    }

    public static List<CustomerResponse<Business>> businessToResponse(List<Business> businesses) {
        List<CustomerResponse<Business>> responses = new ArrayList<CustomerResponse<Business>>();
        for (Business b : businesses) {
            CustomerResponse<Business> r = new CustomerResponse<Business>(b);
            responses.add(r);
        }
        return responses;
    }

    public static ObjectIdContainer addIdToContainer(ObjectId id) {
        ObjectIdContainer idContainer = new ObjectIdContainer();
        idContainer.setId(id.toString());
        return idContainer;
    }

    public static boolean isCustomerValid(Customer customer) {
        boolean customerInfo = false;
        if (customer instanceof Private) {
            customerInfo = customer.getCustomerType() == CustomerType.PRIVATE &&
                    isStringValid((((Private) customer).getFirstName())) &&
                    isStringValid(((Private) customer).getLastName()) &&
                    isPersonalCodeValid(((Private) customer).getPersonalCode()) &&
                    isValueInRange(customer.getAssetPrice(), minPrivateAssetPrice, maxAssetPrice);
        }
        if (customer instanceof Business) {
            customerInfo = customer.getCustomerType() == CustomerType.BUSINESS &&
                    isStringValid(((Business) customer).getCompanyName()) &&
                    isCompanyCodeValid(((Business) customer).getCompanyCode()) &&
                    isValueInRange(customer.getAssetPrice(), minBusinessAssetPrice, maxAssetPrice);

        }

        return customerInfo &&
                isAssetPriceValid(customer.getAssetType()) &&
                isCarBrandValid(customer.getCarBrand()) &&
                isCarModeValid(customer.getCarModel()) &&
                isDateValid(customer.getManufacturedDate()) &&
                isValueInRange(customer.getEnginePower(), minEnginePower, maxEnginePower) &&
                isValueInRange(customer.getAdvancePaymentPercentage(), minAdvancePaymentPercentage, maxAdvancePaymentPercentage) &&
                isAdvancedPaymentAmountValid(customer.getAssetPrice(), customer.getAdvancePaymentPercentage(),
                        new BigDecimal(customer.getAdvancePaymentAmount())) &&
                isContactFeeValid(customer.getAssetPrice(), new BigDecimal(customer.getContractFee())) &&
                isValueInRange(customer.getMargin(), minMargin, maxMargin) &&
                isLeasingPeriodValid(customer.getLeasePeriodInMonths()) &&
                isPaymentDayValid(customer.getPaymentDate()) &&
                isEmailValid(customer.getEmail()) &&
                isPhoneNumberValid(customer.getPhoneNumber()) &&
                isStringValid(customer.getAddress());
    }

    public static boolean isEmailValid(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    public static boolean isCarBrandValid(String carBrand) {
        String regex = "^(?!.*?\\s{2})[A-Za-z ]{0,30}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(carBrand).matches();
    }

    public static boolean isCarModeValid(String carModel) {
        String regex = "^(?!.*?\\s{2})[a-zA-Z0-9 ]{0,30}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(carModel).matches();
    }

    public static boolean isDateValid(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return isDateValid(date, dateFormat);
    }

    public static boolean isDateValid(String date, SimpleDateFormat dateFormat) {
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static boolean isValueInRange(BigDecimal value, BigDecimal min, BigDecimal max) {
        value = value.setScale(2, RoundingMode.HALF_UP);
        min = min.setScale(2, RoundingMode.HALF_UP);
        max = max.setScale(2, RoundingMode.HALF_UP);
        return (value.compareTo(min) >= 0 && value.compareTo(max) <= 0);
    }

    public static boolean isValueInRange(int value, int min, int max) {
        return (value >= min && value <= max);
    }

    public static boolean isAdvancedPaymentAmountValid(BigDecimal assetPrice, BigDecimal percentage,
                                                       BigDecimal advancePaymentAmount) {
        assetPrice = assetPrice.setScale(2, RoundingMode.HALF_UP);
        percentage = percentage.setScale(2, RoundingMode.HALF_UP);
        advancePaymentAmount = advancePaymentAmount.setScale(2, RoundingMode.HALF_UP);
        return ((assetPrice.divide(percentage, 2)).setScale(2, RoundingMode.HALF_UP).equals(advancePaymentAmount));
    }

    public static boolean isContactFeeValid(BigDecimal assetPrice, BigDecimal contractFee) {
        BigDecimal thisContractFee = assetPrice.multiply(new BigDecimal(0.01)).setScale(2, RoundingMode.HALF_UP);
        contractFee = contractFee.setScale(2, RoundingMode.HALF_UP);
        if (thisContractFee.compareTo(new BigDecimal(200)) <= 0) {
            return contractFee.compareTo(new BigDecimal(200)) == 0;
        }
        return thisContractFee.compareTo(contractFee) == 0;
    }

    public static boolean isLeasingPeriodValid(int period) {
        return isValueInRange(period, 6, 84) && period % 6 == 0;
    }

    public static boolean isStringValid(String name) {
        String regex = "\\w{1,65}\\b";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(name).matches();
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        String regex = "(\\+\\d{10,15})";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phoneNumber).matches();
    }

    public static boolean isPersonalCodeValid(String personalCode) {
        String regex = "(\\d{11})";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(personalCode).matches()) {
            return false;
        }

        int firstNumber = Character.getNumericValue(personalCode.charAt(0));
        if (!isValueInRange(firstNumber, 1, 6)) {
            return false;
        }

        String date = personalCode.substring(1, 7);

        return isDateValid(date, new SimpleDateFormat("yyMMdd"));
    }

    public static boolean isCompanyCodeValid(String companyCode) {
        String regex = "(\\d{11})";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(companyCode).matches();
    }

    public static boolean isPaymentDayValid(int day) {
        return day == 15 || day == 30;
    }

    public static boolean isAssetPriceValid(String assetType) {
        return assetType.equals("Vehicle");
    }
}




















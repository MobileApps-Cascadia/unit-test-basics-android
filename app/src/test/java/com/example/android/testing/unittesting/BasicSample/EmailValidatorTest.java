/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.unittesting.BasicSample;

import android.provider.ContactsContract;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Unit tests for the EmailValidator logic.
 */
public class EmailValidatorTest {


    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {

        boolean result = EmailValidator.isValidEmail("name@email.com");
        assertTrue(result);
    }
    @Test
    public void emailValidator_BadEmailSimple_ReturnsFalse() {

        assertFalse(EmailValidator.isValidEmail("my@dot!.biz"));
    }

    //This fails because the email validator is not very sophisticated
    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"));
    }

    //TODO: Find more VALID emails where the validator fails work

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidator_InvalidEmailNoLetterFirstInTLDreturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("name@gmail.0"));
    }

    @Test
    public void emailValidator_InvalidEmailNoTldDot_ReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("name@gmail."));
    }

    @Test
    public void emailValidator_Demonstrates_errors_in_regex_leter_range() {
        assertTrue(EmailValidator.isValidEmail("putin@kremlin.ru"));
    }


    @Test
    public void emailValidator_InvalidEmailPrefixStartsWithDot() {
        assertFalse(EmailValidator.isValidEmail(".name@gmai.com"));
    }

    @Test
    public void emailValidator_InvalidEmailPrefixEndsWithDash() {
        assertFalse(EmailValidator.isValidEmail("name-@gmail.com"));
    }


    @Test
    public void emailValidator_InvalidEmailDoubleUnderscoreInPrefixReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("my__a@underscore.com"));
    }
    @Test
    public void emailValidator_InvalidEmailDoublePeriodInPrefixReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("my..b@abcd.com"));
        }
    @Test
    public void emailValidator_InvalidEmailUnderscorePeriodReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("ab_.hello@email.com"));
    }

    @Test
    public void emailValidator_InvalidEmailPeriodUnderscoreReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("ab._hello@email.com"));
    }
    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsTrue() {
        assertFalse(EmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}

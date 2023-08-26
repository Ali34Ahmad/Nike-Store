package com.example.composeplayground.ui.screens.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.R
import com.example.composeplayground.ui.components.ButtonComponent
import com.example.composeplayground.ui.components.CheckBoxComponent
import com.example.composeplayground.ui.components.CheckBoxComponent2
import com.example.composeplayground.ui.components.ClickableLoginTextComponent
import com.example.composeplayground.ui.components.BirthdayTextField
import com.example.composeplayground.ui.components.DividerComponent
import com.example.composeplayground.ui.components.HeadingTextComponent
import com.example.composeplayground.ui.components.IconButtonComponent
import com.example.composeplayground.ui.components.MyTextField
import com.example.composeplayground.ui.components.NikeLogoComponent
import com.example.composeplayground.ui.components.NikeTextComponent
import com.example.composeplayground.ui.components.SubTextComponent
import com.example.composeplayground.ui.components.PasswordTextField
import com.example.composeplayground.ui.screens.PostOfficeAppRouter
import com.example.composeplayground.ui.screens.Screen
import com.example.composeplayground.ui.theme.colorFacebook
import com.example.composeplayground.ui.theme.colorGray
import com.example.composeplayground.ui.theme.colorNike

@SuppressLint("UnrememberedMutableState")
@Composable
fun SignUpScreen() {
    val usernameTextValid = remember {
        mutableStateOf(false)
    }
    val emailTextValid = remember {
        mutableStateOf(false)
    }
    val passwordTextValid = remember {
        mutableStateOf(false)
    }
    val privacyPolicyChecked = remember {
        mutableStateOf(false)
    }

    val emailText = remember {
        mutableStateOf("")
    }
    val passwordText = remember {
        mutableStateOf("")
    }


    val usernameErrorVisible= remember {
        mutableStateOf(false)
    }
    val emailErrorVisible = remember {
        mutableStateOf(false)
    }
    val passwordErrorVisible = remember {
        mutableStateOf(false)
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp),
        color = Color.White,
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NikeLogoComponent()
            NikeTextComponent(50)
            HeadingTextComponent(value = stringResource(id = R.string.hey_there))
            Spacer(modifier = Modifier.height(5.dp))

            MyTextField(
                labelValue = stringResource(id = R.string.username),
                icon = R.drawable.ic_profile,
                iconDescription = stringResource(id = R.string.username),
                textValid = usernameTextValid,
                textType = stringResource(id = R.string.username),
                emailText=emailText

            )
            SubTextComponent(
                value = stringResource(id = R.string.username_conditions),
                color = colorGray,
                errorMessageVisible=usernameErrorVisible
            )
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                icon = R.drawable.ic_email,
                iconDescription = stringResource(id = R.string.email),
                textValid = emailTextValid,
                textType = stringResource(id = R.string.email),
                emailText=emailText
            )

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                icon = R.drawable.ic_password,
                "Password",
                textValid = passwordTextValid,
                passwordText=passwordText,
                emailText=emailText
            )
            BirthdayTextField(
                labelValue = stringResource(id = R.string.birthday),
                icon = R.drawable.ic_calender,
                iconDescription = "Calender"
            )
            SubTextComponent(
                value = stringResource(id = R.string.get_birthday_reward),
                color = colorGray,
                errorMessageVisible = mutableStateOf(true)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(15.dp)
            )
            CheckBoxComponent(
                textValue = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    PostOfficeAppRouter.navigationTo(Screen.TermsAndConditionsScreen)
                },
                checkedStateValue=privacyPolicyChecked
            )
            CheckBoxComponent2(textValue = stringResource(id = R.string.signup_emails_for_updates))

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(30.dp)
            )
            ButtonComponent(
                text = stringResource(id = R.string.signup),
                enabled = usernameTextValid.value && emailTextValid.value && passwordTextValid.value&&privacyPolicyChecked.value&&(!passwordText.value.contains(emailText.value))
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(20.dp)
            )
            DividerComponent()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(7.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButtonComponent(
                    id = R.drawable.ic_facebook,
                    iconColor = colorFacebook,
                    iconDescription = "Facebook",
                    "Facebook",
                    colorNike
                )
                Spacer(
                    modifier = Modifier
                        .widthIn(20.dp)
                )
                IconButtonComponent(
                    id = R.drawable.ic_googlesvg,
                    iconColor = Color.Unspecified,
                    iconDescription = "Google",
                    textLabel = " Google    ",
                    backgroundColor = colorNike
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(20.dp)
            )

            ClickableLoginTextComponent(onTextSelected = {
                PostOfficeAppRouter.navigationTo(Screen.TermsAndConditionsScreen)
            })
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
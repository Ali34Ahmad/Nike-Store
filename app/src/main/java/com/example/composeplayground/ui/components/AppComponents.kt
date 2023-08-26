package com.example.composeplayground.ui.components

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.R
import com.example.composeplayground.domain.Validator
import com.example.composeplayground.ui.theme.colorBG
import com.example.composeplayground.ui.theme.colorGray
import com.example.composeplayground.ui.theme.colorLighterGray
import com.example.composeplayground.ui.theme.colorNike
import com.example.composeplayground.ui.theme.colorNikeDisabled
import com.example.composeplayground.ui.theme.colorPrimary
import com.example.composeplayground.ui.theme.colorText
import com.example.composeplayground.ui.theme.colorWhite
import com.example.composeplayground.ui.theme.futuraFamily
import java.time.LocalDate
import java.time.format.DateTimeFormatter


//Finished-----------------------------------------------------------------------
@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorText,
        textAlign = TextAlign.Center
    )
}


@Composable
fun NikeLogoComponent() {
    Image(
        painter = painterResource(id = R.drawable.ic_nike),
        contentDescription = "Nike Logo",
        modifier = Modifier.width(120.dp)
    )
}

@Composable
fun NikeTextComponent(textSize: Int) {
    Text(
        text = stringResource(id = R.string.nike),
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-20).dp),
        textAlign = TextAlign.Center,
        fontSize = textSize.sp,
        style = TextStyle(
            fontFamily = futuraFamily,
            fontWeight = FontWeight.Bold
        )
    )
}

@SuppressLint("RememberReturnType")
@Composable
fun CheckBoxComponent(
    textValue: String,
    onTextSelected: (String) -> Unit,
    checkedStateValue: MutableState<Boolean>
) {
    val checkedState = rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 3.dp, end = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                checkedStateValue.value = checkedState.value
            },
            colors = CheckboxDefaults.colors(colorNike)
        )
        ClickableTextComponent(value = textValue, onTextSelected)
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun CheckBoxComponent2(textValue: String) {
    val checkedState = rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 3.dp, end = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
            },
            colors = CheckboxDefaults.colors(colorNike)
        )
        Text(
            text = textValue,
            fontSize = 16.sp,

            )
    }
}


@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = CenterVertically
    ) {
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorGray
        )
        Text(
            text = "Or Via",
            fontSize = 16.sp,
            color = colorText,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorGray
        )


    }
}


@Composable
fun IconButtonComponent(
    id: Int,
    iconColor: Color,
    iconDescription: String,
    textLabel: String,
    backgroundColor: Color
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(10.dp))
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .widthIn(24.dp)
                    .heightIn(24.dp)
                    .padding(5.dp)
                    .size(24.dp)
                    .clip(CircleShape),
                painter = painterResource(id),
                contentDescription = iconDescription,
                tint = iconColor
            )
            Text(
                text = textLabel,
                fontSize = 16.sp
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayTextField(
    labelValue: String,
    icon: Int,
    iconDescription: String
) {
    var date by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) } // state to control the dialog

    val context = LocalContext.current
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            R.style.DatePickerTheme,
            { _, year, month, day ->
                // format the date as you wish
                date = "$day/${month + 1}/$year"
            },
            2003, // default year
            1, // default month (January)
            1 // default day
        )
    }

    if (showDialog) {
        datePickerDialog.show() // show the dialog
        datePickerDialog.window?.let { window ->
            window.setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            window.attributes.dimAmount = 0.5f
            window.setGravity(Gravity.CENTER)
        }
        showDialog = false // reset the state
    }


    val trailingIconView = @Composable {
        IconButton(
            onClick = { date = "" }, // clear the date value on click
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_clear), // use your own clear icon resource
                contentDescription = "Clear date",
                tint = colorPrimary
            )
        }
    }

    OutlinedTextField(
        label = { Text(text = labelValue) },
        value = date,
        onValueChange = {},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary,
            containerColor = colorBG
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = componentShapes.small)
            .padding(vertical = 10.dp)
            .clickable { showDialog = true }, // show the dialog on click
        leadingIcon = {
            Icon(painter = painterResource(id = icon), contentDescription = iconDescription)
        },
        trailingIcon = if (date.isNotBlank()) trailingIconView else null, // show the trailing icon only if the date is not blank
        enabled = false, // disable the text field input
        singleLine = true,
        maxLines = 1,
        placeholder = { Text(text = "mm/dd/yyyy") }, // show the hint text

    )

    if (showDialog) {
        datePickerDialog.show() // show the dialog
        showDialog = false // reset the state
    }
}


@Composable
fun ButtonComponent(text: String, enabled: Boolean) {
    Button(
        onClick = {
            Log.d("ButtonComponent", enabled.toString())
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorNike,
            disabledContainerColor = colorNikeDisabled,
            disabledContentColor = colorWhite
        ),
        contentPadding = PaddingValues(),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    labelValue: String,
    icon: Int,
    iconDescription: String,
    textValid: MutableState<Boolean>,
    passwordText: MutableState<String>,
    emailText: MutableState<String>
) {
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }
    var passwordError by remember {
        mutableStateOf(false)
    }

    val colorOfSubText8Letters = remember {
        mutableStateOf(
            colorGray
        )
    }
    val colorOfSubTextLettersCases = remember {
        mutableStateOf(
            colorGray
        )
    }


    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        textStyle = TextStyle(fontSize = 16.sp),
        label = { Text(text = labelValue) },
        value = password.value,
        onValueChange = {
            password.value = it
            passwordText.value = password.value
            passwordError = !Validator.isValidPassword(it)

            colorOfSubText8Letters.value =
                if (password.value.length < 8) Color.Red else Color.Green
            colorOfSubTextLettersCases.value = if (passwordError) Color.Red else Color.Green

            textValid.value = !passwordError

        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary,
            containerColor = colorBG
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = componentShapes.small)
            .padding(vertical = 10.dp),
        leadingIcon = {
            Icon(painter = painterResource(id = icon), contentDescription = iconDescription)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val iconDesc = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = iconDesc)
            }

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        visualTransformation =
        if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
    if (passwordError || passwordText.value.isBlank()) {
        SubTextComponent(
            value = stringResource(id = R.string.more_than_8_letters),
            color = colorOfSubText8Letters.value,
            mutableStateOf(true)
        )
        SubTextComponent(
            value = stringResource(id = R.string.Uppercase_lowercase_numbers),
            color = colorOfSubTextLettersCases.value,
            mutableStateOf(true)

        )
    } else {
        if (passwordText.value.contains(emailText.value) && passwordText.value.isNotBlank())
            SubTextComponent(
                value = stringResource(id = R.string.password_contains_email),
                color = Color.Red,
                mutableStateOf(true)
            )
    }

}

@Composable
fun SubTextComponent(
    value: String,
    color: Color,
    errorMessageVisible: MutableState<Boolean>
) {
    if (errorMessageVisible.value) {
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(10.dp)
                .padding(horizontal = 16.dp),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal
            ),
            color = color,
            textAlign = TextAlign.Start
        )
    }
}


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    labelValue: String,
    icon: Int,
    iconDescription: String,
    textValid: MutableState<Boolean>,
    textType: String,
    emailText: MutableState<String>
) {
    val textValue = rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        textStyle = TextStyle(fontSize = 16.sp),
        label = { Text(text = labelValue) },
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            if (textType == "Username")
                textValid.value = Validator.validUsername(textValue.value)
            else if (textType == "Email") {
                textValid.value = Validator.validEmail(textValue.value)
                emailText.value = textValue.value.substringBefore('@')
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary,
            containerColor = colorBG
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = componentShapes.small)
            .padding(vertical = 10.dp),
        leadingIcon = {
            Icon(painter = painterResource(id = icon), contentDescription = iconDescription)
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1
    )
    if (!textValid.value && textType == "Email" && textValue.value.length >= 4) {
        SubTextComponent(
            value = stringResource(id = R.string.email_conditions),
            color = Color.Red,
            errorMessageVisible = mutableStateOf(true)
        )
    }
}


//Almost Finished-------------------------------------------------------------

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText: String = stringResource(id = R.string.initialText)
    val privacyPolicy: String = stringResource(id = R.string.privacyPolicy)
    val andText: String = stringResource(id = R.string.andText)
    val termOfUse: String = stringResource(id = R.string.termOfUse)

    val annotatedString = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                color = colorNike,
                fontSize = 16.sp
            )
        ) {
            append(initialText)
        }
        withStyle(
            style = SpanStyle(
                color = colorNike,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        ) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }

        withStyle(
            style = SpanStyle(
                color = colorNike,
                fontSize = 16.sp
            )
        ) {
            append(andText)
        }
        withStyle(
            style = SpanStyle(
                color = colorNike,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        ) {
            pushStringAnnotation(tag = termOfUse, annotation = termOfUse)
            append(termOfUse)
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(offset, offset)
                .firstOrNull()
                ?.also { span ->
                    if (span.item == termOfUse || span.item == privacyPolicy) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}

//Unfinished

@Composable
fun ClickableLoginTextComponent(onTextSelected: (String) -> Unit) {
    val initialText = "Already have an account? "
    val loginText = "Login"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(
            style = SpanStyle(
                color = colorNike,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        ) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(offset, offset)
                .firstOrNull()
                ?.also { span ->
                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}




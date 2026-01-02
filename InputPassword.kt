@Composable
fun PasswordPreview() {
    var hideState by rememberSaveable { mutableStateOf(false) }
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            text,
            { text = it },
            visualTransformation = if (hideState) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(top = 50.dp),
            label = { Text("password") },
            trailingIcon = {
                IconButton({
                    hideState = !hideState
                }) {
                    if (hideState)
                        Icon(
                            Icons.Filled.ThumbUp,
                            "encrypt password",
                            tint = Color.Red
                        )
                    else
                        Icon(
                            Icons.Filled.ThumbUp,
                            "encrypt password",
                            tint = Color.Black
                        )

                }
            }
        )
    }
}

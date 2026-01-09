@Composable
fun CheckBoxTest() {
    var stateChild1 by rememberSaveable { mutableStateOf(false) }
    var stateChild2 by rememberSaveable { mutableStateOf(false) }
    var stateParent by rememberSaveable { mutableStateOf(ToggleableState(false)) }
    val parentLambda = { state: ToggleableState ->
        when(state){
            ToggleableState.On -> {
                stateChild1 = false
                stateChild2 = false
            }

            ToggleableState.Off -> {
                stateChild1 = true
                stateChild2 = true
            }
            else -> stateParent = ToggleableState.Indeterminate
        }
    }

    LaunchedEffect(stateChild1,stateChild2) {
        stateParent = when{
            stateChild1 && stateChild2 -> ToggleableState.On
            !stateChild1 && !stateChild2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(stateParent, {
                parentLambda(stateParent)
            })

            Text("check Box parent", color = Color.White, fontSize = 20.sp)
        }
        Row(modifier = Modifier.padding(horizontal = 15.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = stateChild1, onCheckedChange = {stateChild1 = it})
            Text("check 1", color = Color.White, fontSize = 20.sp)
        }

        Row(modifier = Modifier.padding(horizontal = 15.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(stateChild2,{stateChild2 = it})
            Text("check 2", color = Color.White, fontSize = 20.sp)
        }
    }
}

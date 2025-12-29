    @Preview
    @Composable
    fun DefaultPreview() {
        FinanBuddyTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                    ConstraintLayout(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                        val (yellowBox, magentaBox, greenBox, grayBox, redBox, blueBox,row) = createRefs()
                        Row(modifier = Modifier.fillMaxWidth().constrainAs(row) {
                            bottom.linkTo(magentaBox.top)
                        }) {

                            Box(
                                modifier = Modifier.size(175.dp).weight(1f)
                                    .background(Color.Cyan)
                            )
                            Box(
                                modifier = Modifier.size(75.dp).weight(0.5f)
                                    .background(Color.Black)
                                    .align(Alignment.CenterVertically)
                            )
                            Box(
                                modifier = Modifier.size(175.dp).weight(1f)
                                    .background(Color.Gray)
                            )
                        }

                        Box(
                            modifier = Modifier.size(75.dp).background(Color.Yellow)
                                .constrainAs(yellowBox) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                })

                        Box(
                            modifier = Modifier.size(175.dp).background(Color.Blue)
                                .constrainAs(blueBox) {
                                    top.linkTo(yellowBox.bottom)
                                    start.linkTo(yellowBox.start)
                                    end.linkTo(yellowBox.end)
                                })
                        Box(
                            modifier = Modifier.size(75.dp).background(Color.Magenta)
                                .constrainAs(magentaBox) {
                                    bottom.linkTo(yellowBox.top)
                                    end.linkTo(yellowBox.start)
                                })
                        Box(
                            modifier = Modifier.size(75.dp).background(Color.Green)
                                .constrainAs(greenBox) {
                                    bottom.linkTo(yellowBox.top)
                                    start.linkTo(yellowBox.end)
                                })

                        Box(
                            modifier = Modifier.size(75.dp).background(Color.Gray)
                                .constrainAs(grayBox) {
                                    top.linkTo(yellowBox.bottom)
                                    end.linkTo(yellowBox.start)
                                })

                        Box(
                            modifier = Modifier.size(75.dp).background(Color.Red)
                                .constrainAs(redBox) {
                                    top.linkTo(yellowBox.bottom)
                                    start.linkTo(yellowBox.end)
                                })
                    }
                }
            }
        }
    }

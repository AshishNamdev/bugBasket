var data = require("sdk/self").data;
// Construct a panel, loading its content from the "text-entry.html"
// file in the "data" directory, and loading the "get-text.js" script
// into it.
var popup = require("sdk/panel").Panel({
  contentURL: data.url("bugBasket.htm"),
  //contentScriptFile: data.url("ui.js")
});

// Create a button
require("sdk/ui/button/action").ActionButton({
  id: "bugBasket",
  label: "bugBasket",
  icon: {
    "16": "./icon-16.png",
    "32": "./icon-32.png",
    "64": "./icon-64.png"
  },
  onClick: handleClick
});

// Show the panel when the user clicks the button.
function handleClick(state) {
  popup.show();
  //add ajax code to fetch and exxtract data from http request/response then show the page
}

// When the panel is displayed it generated an event called
// "show": we will listen for that event and when it happens,
// send our own "show" event to the panel's script, so the
// script can prepare the panel for display.
popup.on("show", function() {
  popup.port.emit("show");
});


// Listen for messages called "text-entered" coming from
// the content script. The message payload is the text the user
// entered.
// In this implementation we'll just log the text to the console.
popup.port.on("text-entered", function (text) {
  console.log(text);
  popup.hide();
});
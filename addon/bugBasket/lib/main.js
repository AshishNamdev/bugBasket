var { ToggleButton } = require('sdk/ui/button/toggle');
var panels = require("sdk/panel");
var self = require("sdk/self");

var button = ToggleButton({
  id: "bugBasket",
  label: "bugBasket",
  icon: {
    "16": "./icon-16.png",
    "32": "./icon-32.png",
    "64": "./icon-64.png"
  },
  onChange: handleChange
});

function handleChange(state) {
  var panel = panels.Panel({
  contentURL: self.data.url("bugBasket.htm"),
  onHide: handleHide
  });

  if (state.checked) {
    panel.show({
      position: button
    });
  }
}

function handleHide() {
  button.state('window', {checked: false});
  panel.destroy();
}
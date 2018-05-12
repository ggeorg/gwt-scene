define(['Core', 'd3'], function(core, d3){
	console.log("D3 loaded!");
	
    if (!window.d3) { 
    	// make d3 global...
    	window.d3 = d3;
    }
});
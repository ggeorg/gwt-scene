define(['D3', 'nvd3'], function(D3, nvd3){
	console.log("NVD3 loaded!");
	
    if (!window.nv) { 
    	// make nvd3 global...
    	window.nv = nvd3;
    }
});
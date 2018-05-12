define(['jquery', 'moment'], function($, moment){
	console.log("Core loaded!");

    if (!window.moment) { 
    	// make moment global...
    	window.moment = moment;
    }
});
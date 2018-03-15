"use strict";

import PageSearch from "./tableControls/pageSearch.js";
import createUpdateTable from "./tableControls/SwineWeight.js";
import TableControls from "./tableControls/tableControls.js";
import SearchControls from "./tableControls/searchControls.js";
import Sorter from "./tableControls/sorter.js";

document.addEventListener("DOMContentLoaded",function(){
	
let itemPage = new PageSearch("/api/swineList");
	
	createUpdateTable(itemPage.url,itemPage.getPageProps()+`&page=${itemPage.page}`);
	
	const pagination = document.getElementById("pagination");
	const selectPageSize = document.getElementById("selectPageSize");
	
	//initialize table controls
	let itemTableControls = new TableControls(createUpdateTable,itemPage);
	itemTableControls.pagination = pagination;
	itemTableControls.selectPageSize = selectPageSize;
	
	//add table controls
	itemTableControls.addPagination();
	itemTableControls.addPageSizeControls();
	
	const selectSearchBy = document.getElementById("selectSearchBy");
	const inputSearch = document.getElementById("inputSearch");
	const btnSearch = document.getElementById("btnSearch");
	
	//Search controls
	let itemSearchControls = new SearchControls(selectSearchBy,inputSearch,btnSearch,itemTableControls);
	itemSearchControls.addSearchControls();
	
	//sorter
	let itemSorter = new Sorter(itemTableControls,0,5);
	itemSorter.addSortIcons();
	
	const th = document.getElementsByTagName("th");
	
	//add sorters
	th[0].addEventListener("click",function(){
		itemSorter.sortTable("swineID");
		itemSorter.setSortedColumn(0);
	});
	
	th[1].addEventListener("click",function(){
		itemSorter.sortTable("type");
		itemSorter.setSortedColumn(1);	
	});
	
	th[2].addEventListener("click",function(){
		itemSorter.sortTable("breed");
		itemSorter.setSortedColumn(2);	
	});
	
	th[3].addEventListener("click",function(){
		itemSorter.sortTable("gender");
		itemSorter.setSortedColumn(3);	
	});
	
	th[4].addEventListener("click",function(){
		itemSorter.sortTable("bday");
		itemSorter.setSortedColumn(4);	
	});
	
	th[5].addEventListener("click",function(){
		itemSorter.sortTable("description");
		itemSorter.setSortedColumn(5);
	});
	
});
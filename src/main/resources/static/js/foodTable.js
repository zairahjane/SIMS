"use strict";

import PageSearch from "./tableControls/pageSearch.js";
import createUpdateTable from "./tableControls/updateTable.js";
import TableControls from "./tableControls/tableControls.js";
import SearchControls from "./tableControls/searchControls.js";
import Sorter from "./tableControls/sorter.js";

document.addEventListener("DOMContentLoaded",function(){
	
	let itemPage = new PageSearch("/api/foodList");
	
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
	let itemSorter = new Sorter(itemPage,0,6,itemTableControls);
	itemSorter.addSortIcons();
	
	const th = document.getElementsByTagName("th");
	
	//add sorters
	th[0].addEventListener("click",function(){
		itemSorter.sortTable("id");
		itemSorter.setSortedColumn(0);
	});
	
	th[1].addEventListener("click",function(){
		itemSorter.sortTable("prodname");
		itemSorter.setSortedColumn(1);	
	});
	
	th[2].addEventListener("click",function(){
		itemSorter.sortTable("classification");
		itemSorter.setSortedColumn(2);	
	});
	
	th[3].addEventListener("click",function(){
		itemSorter.sortTable("quantity");
		itemSorter.setSortedColumn(3);	
	});
	
	th[4].addEventListener("click",function(){
		itemSorter.sortTable("weight");
		itemSorter.setSortedColumn(4);	
	});
	
	th[5].addEventListener("click",function(){
		itemSorter.sortTable("expdate");
		itemSorter.setSortedColumn(5);	
	});
	
	th[6].addEventListener("click",function(){
		itemSorter.sortTable("description");
		itemSorter.setSortedColumn(6);
	});
	
});
import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';
import PlanCard from '../components/PlanCard';

import '../styles/paginator.scss';

export default function Paginator({ itemsPerPage }) {
    
    const [currentItems, setCurrentItems] = useState(null);
    const [pageCount, setPageCount] = useState(0);
    const [itemOffset, setItemOffset] = useState(0);

    const plans = useSelector(state => state.plans);
  
    useEffect(() => {
        const endOffset = itemOffset + itemsPerPage;
        console.log(`Loading items from ${itemOffset} to ${endOffset}`);
        setCurrentItems(plans.slice(itemOffset, endOffset));
        setPageCount(Math.ceil(plans.length / itemsPerPage));
    }, [itemOffset, itemsPerPage, plans]);
  

    const handlePageClick = (event) => {
        const newOffset = (event.selected * itemsPerPage) % plans.length;
        console.log(
            `User requested page number ${event.selected}, which is offset ${newOffset}`
        );
        setItemOffset(newOffset);
    };
  
    return (
        <>
            <div className="plan-cards-list">
                <Items currentItems={currentItems} />
            </div>
            <div className="plan-cards-paginator">
                <ReactPaginate
                    breakLabel="..."
                    nextLabel="next >"
                    onPageChange={handlePageClick}
                    pageRangeDisplayed={5}
                    pageCount={pageCount}
                    previousLabel="< previous"
                    renderOnZeroPageCount={null}
                />
            </div>
        </>
    );
}

function Items({ currentItems }) {
    return (
        <>
            {currentItems &&
                currentItems.map((item, ind) => (
                    <PlanCard planDetails={item} key={ind}/>
            ))}
        </>
    );
}

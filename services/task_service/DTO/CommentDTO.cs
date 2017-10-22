using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tasks.DTO
{
    public class CommentDTO
    {
        public DateTime Date { get; set; }
        public string Username { get; set; }
        public string Message { get; set; }
    }
}
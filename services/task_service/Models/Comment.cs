using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Tasks.Models
{
    public class Comment
    {
        [Key]
        public int Id { get; set; }

        public int Task { get; set; }
        public DateTime TimeStamp { get; set; }
        public string User { get; set; }
        public string Message { get; set; }
    }
}
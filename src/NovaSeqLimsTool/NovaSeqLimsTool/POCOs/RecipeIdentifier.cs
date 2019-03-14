using System;
using System.Collections.Generic;
using System.Text;

namespace NovaSeqLimsTool.POCOs
{
    public class RecipeIdentifier
    {
        public string FlowCellId { get; set; }
        public string LibraryContainerId { get; set; }
        public IEnumerable<Reagent> Reagents { get; set; }

        public override string ToString()
        {
            var reagentStringBuilder = new StringBuilder();
            reagentStringBuilder.Append($"[{Environment.NewLine}");
            foreach (var r in Reagents)
            {
                reagentStringBuilder.Append(r);
                reagentStringBuilder.Append(Environment.NewLine);
            }
            reagentStringBuilder.Append($"]{Environment.NewLine}");
            return $"{Environment.NewLine}[{Environment.NewLine}Recipe Identifier: {Environment.NewLine}" +
                   $"FlowCellId: {FlowCellId}{Environment.NewLine}" +
                   $"LibraryContainerId: {LibraryContainerId}{Environment.NewLine}" +
                   $"Reagents: {reagentStringBuilder}{Environment.NewLine}]";
        }
    }
}
